-- ============================================================
-- ENUMERACIONES (TIPOS)
-- ============================================================
/*
CREATE TYPE PARTNER_LOCATION_TYPE AS ENUM(
	'Place of Birth',
	'Residential Address',
	'Domicile Address',
	'Work Address'
);
CREATE TYPE civil_status_type AS ENUM (
    'Single',
    'Married',
    'Divorced',
    'Widowed',
    'Separated',
    'DomesticPartnership'
);
CREATE TYPE contact_point_type AS ENUM (
    'Electronic Address',
    'Postal Address',
    'Phone Number',
    'SocialNetworkAddress'
);
CREATE TYPE partner_profile_type AS ENUM (
    'EducationProfile',
    'EmploymentProfile',
    'KYC/RiskProfile'
);
CREATE TYPE partner_identification_type AS ENUM (
    'SocialSecurityNumber',
    'DriversLicenseNumber',
    'PassportNumber',
    'IdentityCardNumber',
    'EmployerIdentificationNumber',
    'AlienRegistrationNumber',
    'CustomerIdentificationNumber',
    'EmployeeIdentificationNumber',
    'NationalIdentityNumber',
    'TelephoneNumber',
    'TaxIdentificationNumber'
);
CREATE TYPE political_exposure_type AS ENUM (
    'PoliticalExposureForeign',
    'PoliticalExposureDomestic',
    'NoPoliticalExposure'
);
*/
CREATE TYPE PARTNER_LOCATION_TYPE AS ENUM(
	'Lugar de Nacimiento', 
	'Dirección Residencial', 
	'Dirección de Domicilio', 
	'Dirección de Trabajo'
);

CREATE TYPE civil_status_type AS ENUM (
	'Soltero', 
	'Casado', 
	'Divorciado', 
	'Viudo', 
	'Separado', 
	'Union de hecho'
);
CREATE TYPE contact_point_type AS ENUM (
    'Dirección Electrónica', 
	'Dirección Postal', 
	'Número de Teléfono', 
	'Dirección de Red Social'
);
CREATE TYPE partner_profile_type AS ENUM (
    'Perfil Educativo', 
	'Perfil Laboral', 
	'PerfilKYC/Riesgo'
);
CREATE TYPE partner_identification_type AS ENUM (
    'Cédula',
	'RUCS',
	'Pasaporte'
);
CREATE TYPE political_exposure_type AS ENUM (
    'Exposición Política Extranjera', 
	'Exposición Política Nacional', 
	'Sin Exposición Política'
);
CREATE TYPE name_prefix_type AS ENUM (
    'Mr',
    'Mrs',
    'Ms',
    'Dr',
    'Prof',
    'Rev'
);




-- ============================================================
-- TABLA: country
-- ============================================================
CREATE TABLE country (
    country_id                      SERIAL PRIMARY KEY,
    country_name                    VARCHAR(100) NOT NULL,
    country_code                    CHAR(2) UNIQUE NOT NULL,
    created_at      TIMESTAMP DEFAULT NOW(),
    updated_at      TIMESTAMP DEFAULT NOW()
);



-- ============================================================
-- TABLA: partner
-- ============================================================
CREATE TABLE partner (
    partner_id              SERIAL PRIMARY KEY,
	identification_type     partner_identification_type NOT NULL,
    identification_value    VARCHAR(100) NOT NULL,
	first_name      		VARCHAR(100) NOT NULL,
    middle_name     		VARCHAR(100),
    last_name       		VARCHAR(100) NOT NULL,
    full_name       		VARCHAR(255) GENERATED ALWAYS AS (first_name || ' ' || COALESCE(middle_name || ' ', '') || last_name) STORED,
    birth_date              DATE,
    nationality             CHAR(2) REFERENCES country(country_code),
    residential_status      VARCHAR(50),
    ethnicity               TEXT,
    religion                TEXT,
    civil_status            civil_status_type,
    job_title               VARCHAR(255),
    name_prefix             name_prefix_type,
	state					BOOLEAN DEFAULT TRUE,
    created_at              TIMESTAMP DEFAULT NOW(),
    updated_at              TIMESTAMP DEFAULT NOW()
);
COMMENT ON TABLE partner IS 'Socio\persona física según BIAN Person Helper Diagram';

-- ============================================================
-- TABLA: partner_location
-- ============================================================
CREATE TABLE partner_location (
    partner_location_id     SERIAL PRIMARY KEY,
    partner_id              INTEGER NOT NULL REFERENCES partner(partner_id) ON DELETE CASCADE,
	partner_location_type   partner_location_type NOT NULL,
    country_code    		CHAR(2),
	state_province  		VARCHAR(100),
	city            		VARCHAR(100),    
	address_line1   		VARCHAR(255),
    address_line2   		VARCHAR(255),    
    postal_code     		VARCHAR(20),    
    created_at      		TIMESTAMP DEFAULT NOW(),
    updated_at      		TIMESTAMP DEFAULT NOW()
);


COMMENT ON TABLE partner_location IS 'Ubicaciones del Socio\persona';


-- ============================================================
-- TABLA: profile
-- Relación 0..1 a 0..* entre Person y Profile
-- ============================================================
CREATE TABLE profile (
    profile_id               		SERIAL PRIMARY KEY,
    partner_id                      INTEGER NOT NULL REFERENCES partner(partner_id) ON DELETE CASCADE,
    profile_type                    partner_profile_type NOT NULL,
	description     				TEXT,
    political_exposure_type         political_exposure_type,
    political_exposure_description  TEXT,
    salary_range                    VARCHAR(100),
    employee_termination_indicator  BOOLEAN DEFAULT FALSE,
    family_medical_insurance_ind    BOOLEAN DEFAULT FALSE,
    education_level                 TEXT,
    profession                      VARCHAR(255),
    created_at                      TIMESTAMP DEFAULT NOW(),
    updated_at                      TIMESTAMP DEFAULT NOW()
);
COMMENT ON TABLE profile IS 'Perfiles del socio: EducationProfile, EmploymentProfile, KYC/RiskProfile';

-- ============================================================
-- TABLA: contact_point
-- ============================================================
CREATE TABLE contact_point (
    contact_point_id    			SERIAL PRIMARY KEY,    
    contact_point_type  			contact_point_type NOT NULL,
    contact_value       			VARCHAR(500) NOT NULL,  -- email, phone, address, etc.
    is_primary          			BOOLEAN DEFAULT FALSE,
    valid_from          			DATE,
    valid_to            			DATE,
    created_at                      TIMESTAMP DEFAULT NOW(),
    updated_at                      TIMESTAMP DEFAULT NOW()
);


-- ============================================================
-- VISTA: partner_full_view
-- Vista consolidada de datos del socio
-- ============================================================
CREATE VIEW partner_full_view AS
SELECT
    p.partner_id,
    p.birth_date,
    p.residential_status,
    p.civil_status,
    p.job_title,
    p.name_prefix,
    p.ethnicity,
    p.religion,
    -- Nombre principal
    pn.name_value AS primary_name,
    pn.name_type  AS primary_name_type,
    -- País de nacionalidad
    c.country_name AS nationality_country,
    -- Identificación principal
    pi.identification_type AS primary_id_type,
    pi.identifier_value    AS primary_id_value
FROM partner p
LEFT JOIN partner_name pn ON pn.partner_id = p.partner_id AND pn.name_type = 'Full Name'
LEFT JOIN country c ON c.country_code = p.nationality
LEFT JOIN partner_identification pi ON pi.partner_id = p.partner_id
    AND pi.identifier_end_date IS NULL;

COMMENT ON VIEW partner_full_view IS 'Vista consolidada de datos básicos del socio';


CREATE TYPE transaction_type_values AS ENUM (
    'Financial Transaction',
    'Business Transaction',
    'Banking Transaction',
    'Accounting Transaction',
    'Booking Transaction',
    'Allocation Transaction',
    'Delivery Transaction',
    'Production Transaction'
);
-- ============================================================
-- TABLA: transaction (clase base)
-- ============================================================
CREATE TABLE transaction (
    transaction_id          SERIAL PRIMARY KEY,
    -- Datatype Identifier
    transaction_identifier  VARCHAR(255) UNIQUE NOT NULL,
    transaction_type        transaction_type_values NOT NULL,
    transaction_description TEXT,
    transaction_name        VARCHAR(255),
    created_at              TIMESTAMP DEFAULT NOW(),
    updated_at              TIMESTAMP DEFAULT NOW()
);

COMMENT ON TABLE transaction IS 'Clase base para todos los tipos de transacción según BIAN';


CREATE TYPE financial_transaction_type_values AS ENUM (
    'Pricing Transaction',
    'Fee Transaction',
    'Withdrawal Transaction',
    'Deposit Transaction',
    'Payment Transaction',
    'Clearing Transaction',
    'Settlement Transaction',
    'ReconciliationTransaction',
    'UpdateTransaction',
    'SecuritiesTransaction',
    'Repayment Transaction'
);
-- ============================================================
-- TABLA: financial_transaction
-- Especialización de transaction para transacciones financieras
-- ============================================================
CREATE TABLE financial_transaction (
    financial_transaction_id        SERIAL PRIMARY KEY,
	-- Datatype Identifier
    transaction_identifier  		VARCHAR(255) UNIQUE NOT NULL,
    transaction_type        		transaction_type_values NOT NULL,
    transaction_description 		TEXT,
    transaction_name        		VARCHAR(255),
    financial_transaction_type      financial_transaction_type_values NOT NULL,
    financial_transaction_currency  CHAR(3) NOT NULL,
    financial_transaction_amount    NUMERIC(20, 4) NOT NULL,
	-- from_bank_id
    from_account_id                 INTEGER REFERENCES account(account_id),
	--target_bank_id
    target_account_id               INTEGER REFERENCES account(account_id),
    created_at              		TIMESTAMP DEFAULT NOW(),
    updated_at              		TIMESTAMP DEFAULT NOW()
);

COMMENT ON TABLE financial_transaction IS 'Transacción financiera con monto, moneda y cuentas origen/destino';


-- ============================================================
-- ÍNDICES para mejorar performance
-- ============================================================

CREATE INDEX idx_person_party_id ON person(party_id);

CREATE INDEX idx_contact_point_party_id ON contact_point(party_id);
CREATE INDEX idx_person_location_person_id ON person_location(person_id);

CREATE INDEX idx_customer_relationship_party ON customer_relationship(party_id);
CREATE INDEX idx_party_profile_party_id ON party_profile(party_id);
CREATE INDEX idx_directory_entry_party ON party_reference_data_directory_entry(party_id);

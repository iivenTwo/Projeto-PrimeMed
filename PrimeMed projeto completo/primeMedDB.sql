ALTER TABLE paciente MODIFY estado_civil VARCHAR(20) NULL;
ALTER TABLE exame MODIFY paciente_id INT NULL;


-- Tabela de Usuários (Colaboradores: Médicos / Administradores)
CREATE TABLE IF NOT EXISTS usuario (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(20) NOT NULL UNIQUE,
    nascimento DATE NOT NULL,
    sexo ENUM('Masculino', 'Feminino') NOT NULL,
    estado_civil ENUM('Solteiro(a)', 'Casado(a)') NOT NULL,
    rg VARCHAR(20),
    cep VARCHAR(10),
    endereco VARCHAR(150),
    telefone VARCHAR(20),
    crm VARCHAR(20),
    tipo_usuario ENUM('Profissional da Saúde', 'Administrador') NOT NULL,
    especialidade VARCHAR(50) NOT NULL
);

-- Tabela de Pacientes
CREATE TABLE IF NOT EXISTS paciente (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    nascimento DATE NOT NULL,
    sexo ENUM('Masculino', 'Feminino') NOT NULL,
    cpf VARCHAR(20) NOT NULL UNIQUE,
    rg VARCHAR(20),
    cep VARCHAR(10),
    endereco VARCHAR(150),
    estado_civil ENUM('Sim', 'Não') NOT NULL,
    numero_convenio VARCHAR(50),
    telefone VARCHAR(20),
    email VARCHAR(100),
    convenio ENUM('Sim', 'Não') NOT NULL
);

-- Agendamentos (feito por médico ou administrador)
CREATE TABLE IF NOT EXISTS agendamento (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT NOT NULL,
    usuario_id INT NOT NULL,
    data_hora DATETIME NOT NULL,
    descricao VARCHAR(255),
    status ENUM('Agendado', 'Cancelado', 'Concluído') DEFAULT 'Agendado',
    FOREIGN KEY (paciente_id) REFERENCES paciente(id) ON DELETE CASCADE,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);

-- Diagnóstico (feito por médico)
CREATE TABLE IF NOT EXISTS diagnostico (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT NOT NULL,
    usuario_id INT NOT NULL,
    descricao TEXT NOT NULL,
    data_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id) ON DELETE CASCADE,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);

-- Medicamentos em uso (feito por médico)
CREATE TABLE IF NOT EXISTS medicamento_uso (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT NOT NULL,
    usuario_id INT NOT NULL,
    nome_medicamento VARCHAR(100) NOT NULL,
    dosagem VARCHAR(50),
    frequencia VARCHAR(50),
    observacoes TEXT,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id) ON DELETE CASCADE,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);

-- Orientações (feito por médico)
CREATE TABLE IF NOT EXISTS orientacao (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT NOT NULL,
    usuario_id INT NOT NULL,
    texto_orientacao TEXT NOT NULL,
    data_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id) ON DELETE CASCADE,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);

-- Alergias (feito por médico)
CREATE TABLE IF NOT EXISTS alergia (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT NOT NULL,
    usuario_id INT NOT NULL,
    descricao VARCHAR(255) NOT NULL,
    severidade VARCHAR(100),
    observacoes TEXT,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id) ON DELETE CASCADE,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);

-- Exames (feito por médico)
CREATE TABLE IF NOT EXISTS exame (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT NOT NULL,
    usuario_id INT NOT NULL,
    tipo_exame VARCHAR(100),
    resultado TEXT,
    data_exame DATE,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id) ON DELETE CASCADE,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);

-- Prontuários (feito por médico)
CREATE TABLE IF NOT EXISTS prontuario (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT NOT NULL,
    usuario_id INT NOT NULL,
    queixas TEXT,
    alergias TEXT,
    medicamentos_uso TEXT,
    historico_familiar TEXT,
    data_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id) ON DELETE CASCADE,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE CASCADE
);

-- Queixas (feito por médico)
CREATE TABLE IF NOT EXISTS queixa (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT NOT NULL,
    descricao TEXT NOT NULL,
    data_registro DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id) ON DELETE CASCADE
);

-- Histórico Familiar (feito por médico)
CREATE TABLE IF NOT EXISTS historico_familiar (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT NOT NULL,
    descricao TEXT NOT NULL,
    FOREIGN KEY (paciente_id) REFERENCES paciente(id) ON DELETE CASCADE
);

SELECT * FROM exame;


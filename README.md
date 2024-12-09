Sistema de Controle de Multas e Ocorrências de Trânsito
Este software foi desenvolvido para gerenciar ocorrências de trânsito, calcular infrações e gerar relatórios detalhados. O sistema permite importar ocorrências de arquivos, processá-las para aplicar penalidades com base nas regras estabelecidas e exportar relatórios em formatos JSON ou CSV.

Principais Funcionalidades
Cadastro e Processamento de Ocorrências
Inserção de Ocorrências: Registra informações como placa do veículo, local, data/hora e tipo de infração.
Processamento Automático: Aplica regras de trânsito para gerar multas com base nas ocorrências cadastradas.

Regras de Penalidade
Suporte a diferentes categorias de regras, incluindo:
Excesso de velocidade;
Violação de rodízio;

Circulação indevida em corredores exclusivos de ônibus.
Multas são calculadas automaticamente conforme as regras.
Consulta e Listagem
Busca Multas: Realiza consultas filtrando por data ou pela placa do veículo.
Listagens: Exibe ocorrências processadas, pendentes, e multas geradas.

Relatórios e Exportação
Exportação de Relatórios: Gera arquivos CSV ou JSON contendo os dados das multas para análises futuras.
Tecnologias Utilizadas
Java: Linguagem principal para implementação da lógica.
Gson: Biblioteca para manipulação e exportação de dados em JSON.
Manipulação de Arquivos: Suporte a leitura de arquivos CSV/TXT e escrita de relatórios.

Estrutura do Projeto
Classes Principais
Ocorrencia: Representa eventos de trânsito (placa, local, horário e tipo de infração).
Multa: Modela as penalidades aplicadas, contendo informações como placa, descrição da infração e valor da multa.
RegraMulta: Classe base para as regras de trânsito. Subclasses específicas determinam o cálculo de multas para situações como excesso de velocidade e rodízio.
BaseDeDados: Responsável por armazenar ocorrências e multas, processar infrações e gerar relatórios.

Pré-requisitos
Java 8 ou superior.
Biblioteca Gson para manipulação de JSON (adicionar no pom.xml se usar Maven ou incluir manualmente o JAR).

Lógica de Penalidades
Regras de Multas
As multas são aplicadas com base em diferentes regras, como:

Velocidade: Penalidades para veículos que ultrapassam os limites da via.
Rodízio: Multas para veículos circulando em dias restritos.
Corredores de Ônibus: Penalidades por uso irregular de faixas exclusivas.

Processamento de Infrações
O sistema analisa cada ocorrência registrada.
Verifica quais regras são aplicáveis.
Gera as multas de acordo com os critérios definidos.

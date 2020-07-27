# Flatland

Flatland é um archetype para projetos que seguem a arquitetura Rest. Fornecendo as funcionalidades abaixo.

- Maven com profiles e projeto separado em módulos
- Configurações do ecossistema Spring
- Validação de input e business
- Template de mensagem default
- Autenticação JWT integrado com o Spring Security
- E muito mais

## Começando

Essas instruções vão te ajudar a ter uma copia do projeto rodando em sua maquina local para desenvolvimento.

### Configurando e instalando

1. Configurar o [context.xml](https://github.com/lucasromagnoli/flatland/blob/master/flatland-web/src/main/webapp/META-INF/context.xml) com os dados da conexão ao banco de dados.
1. Gerar a chave pública e privada responsável por assinar o token JWT. As chaves podem ser geradas pelo software [key-generator-tool](https://github.com/lucasromagnoli/key-generator/releases/tag/V1.0.0)
1. Inserir as chaves em `/br/com/lucasromagnoli/flatland/keys/`
1. Compilar o projeto base [Underpinning](https://github.com/lucasromagnoli/underpinning)
1. Inserir as [tabelas básicas](https://github.com/lucasromagnoli/flatland/blob/master/flatland.sql)


## Exemplos
```
1. Exemplo - Autenticação
```
![demonstração-1](https://i.ibb.co/9rGTL79/demo1.png)

```
2. Exemplo - Validação de dados
```
![demonstração-2](https://i.ibb.co/yp8Xdf1/Sem-t-tulo.png)

## Compilado com

* [Maven](https://maven.apache.org/) - Gerenciamento de Dependências

## Versionamento

Nós utilizamos o padrão [SemVer](http://semver.org/) para o versionamento. Para verificar as versões disponiveis, veja em [tags](https://github.com/lucasromagnoli/flatland/tags)

## Autores

* **Lucas Ramos Romagnoli** - [lucasromagnoli](https://github.com/lucasromagnoli)

## Licença

Este projeto está licenciado sob a licença MIT - veja mais detalhes em [LICENSE.md](https://github.com/lucasromagnoli/flatland/blob/master/LICENSE)

// filepath: /README.md
# MOOC-Lutece

...existing code...

# MOOC-Lutece — repository overview

This repository contains a Lutece plugin example (plugin-examplemse) and a small Node/TypeScript MySQL demo project. Use this README to quickly locate key sources, build instructions and useful notes.

## Contents (high level)
- plugin-examplemse/ — Lutece plugin
  - [pom.xml](plugin-examplemse/pom.xml)
  - Core Java sources: business layer, DAO and web controllers
    - [`fr.paris.lutece.plugins.examplemse.business.Project`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/business/Project.java)
    - [`fr.paris.lutece.plugins.examplemse.business.ProjectDAO`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/business/ProjectDAO.java)
    - [`fr.paris.lutece.plugins.examplemse.business.IProjectDAO`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/business/IProjectDAO.java)
    - [`fr.paris.lutece.plugins.examplemse.business.ProjectHome`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/business/ProjectHome.java)
    - [`fr.paris.lutece.plugins.examplemse.business.AbstractFilterDao`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/business/AbstractFilterDao.java)
    - Admin MVC/JSP controller: [`fr.paris.lutece.plugins.examplemse.web.ProjectJspBean`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/web/ProjectJspBean.java)
    - XPage controller: [`fr.paris.lutece.plugins.examplemse.web.ProjectXPage`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/web/ProjectXPage.java)
    - Admin helper: [`fr.paris.lutece.plugins.examplemse.web.AbstractJspBean`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/web/AbstractJspBean.java)
  - Templates and JSPs:
    - Admin templates: [webapp/WEB-INF/templates/admin/plugins/examplemse/](plugin-examplemse/webapp/WEB-INF/templates/admin/plugins/examplemse/)
    - Front templates: [webapp/WEB-INF/templates/skin/plugins/examplemse/](plugin-examplemse/webapp/WEB-INF/templates/skin/plugins/examplemse/)
    - Admin JSP entry: [webapp/jsp/admin/plugins/examplemse/ManageProjects.jsp](plugin-examplemse/webapp/jsp/admin/plugins/examplemse/ManageProjects.jsp)
  - Plugin descriptor / spring config:
    - [webapp/WEB-INF/plugins/examplemse.xml](plugin-examplemse/webapp/WEB-INF/plugins/examplemse.xml)
    - [webapp/WEB-INF/conf/plugins/examplemse_context.xml](plugin-examplemse/webapp/WEB-INF/conf/plugins/examplemse_context.xml)
  - SQL for plugin schema:
    - [src/sql/plugins/examplemse/plugin/create_db_examplemse.sql](plugin-examplemse/src/sql/plugins/examplemse/plugin/create_db_examplemse.sql)
    - [src/sql/plugins/examplemse/core/init_core_examplemse.sql](plugin-examplemse/src/sql/plugins/examplemse/core/init_core_examplemse.sql)
  - Tests:
    - [src/test/java/.../ProjectBusinessTest.java](plugin-examplemse/src/test/java/fr/paris/lutece/plugins/examplemse/business/ProjectBusinessTest.java)
    - [src/test/java/.../ProjectJspBeanTest.java](plugin-examplemse/src/test/java/fr/paris/lutece/plugins/examplemse/web/ProjectJspBeanTest.java)
    - [src/test/java/.../ProjectXPageTest.java](plugin-examplemse/src/test/java/fr/paris/lutece/plugins/examplemse/web/ProjectXPageTest.java)

- mysql-db-project/ — small Node + MySQL demo
  - [package.json](plugin-examplemse/mysql-db-project/package.json)
  - [docker-compose.yml](plugin-examplemse/mysql-db-project/docker-compose.yml)
  - App entry: [src/app.ts](plugin-examplemse/mysql-db-project/src/app.ts)
  - DB init SQL: [src/migrations/init.sql](plugin-examplemse/mysql-db-project/src/migrations/init.sql)
  - TS models starter: [src/models/index.ts](plugin-examplemse/mysql-db-project/src/models/index.ts)
  - README: [mysql-db-project/README.md](plugin-examplemse/mysql-db-project/README.md)

## Quick tasks

- Build the plugin (Maven):
```sh
# from repository root
mvn -f plugin-examplemse/pom.xml package
```

- Run the Node MySQL demo:
```sh
cd plugin-examplemse/mysql-db-project
npm install
# start (uses ts-node per package.json)
npm start
# or start DB via docker-compose:
docker-compose up -d
```

## How the plugin is organized (short)
- Business objects and persistence:
  - [`Project`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/business/Project.java) is the domain model.
  - DAO logic in [`ProjectDAO`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/business/ProjectDAO.java) implements [`IProjectDAO`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/business/IProjectDAO.java).
  - Service facade is [`ProjectHome`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/business/ProjectHome.java).
- Web/UI:
  - Admin controller is [`ProjectJspBean`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/web/ProjectJspBean.java) (JSP/admin MVC).
  - Public XPage controller is [`ProjectXPage`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/web/ProjectXPage.java).
  - Template files live under webapp/WEB-INF/templates.

## Notes & known issues to check
- There are a few suspicious lines in DAO and loadFromDaoUtil; see [`ProjectDAO`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/business/ProjectDAO.java) for index/assignment correctness.
- Validation annotations and cost validation are defined in [`Project`](plugin-examplemse/src/java/fr/paris/lutece/plugins/examplemse/business/Project.java).
- Spring bean id is defined in [plugins/examplemse_context.xml](plugin-examplemse/webapp/WEB-INF/conf/plugins/examplemse_context.xml).

## Tests
- Java unit tests are located under [plugin-examplemse/src/test/java](plugin-examplemse/src/test/java).
- Run tests with Maven (standard surefire): `mvn -f plugin-examplemse/pom.xml test`

## Contributing / Development
- Edit Java code under `plugin-examplemse/src/java/`.
- Edit templates under `plugin-examplemse/webapp/WEB-INF/templates/`.
- If you change DB schema, update `plugin-examplemse/src/sql/...` and re-run DB migrations.

---

If you want, I can:
- generate a more detailed README for the plugin-only or the mysql-demo-only,
- open a short checklist of fixes for the DAO and tests.

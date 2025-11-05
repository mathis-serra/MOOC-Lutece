# MySQL Database Project

This project demonstrates how to set up a Node.js application with a MySQL or MariaDB database. It includes configuration, models, migrations, and a basic application structure.

## Project Structure

```
mysql-db-project
├── src
│   ├── config
│   │   └── database.ts       # Database configuration
│   ├── models
│   │   └── index.ts          # Database models
│   ├── migrations
│   │   └── init.sql          # Database initialization SQL
│   └── app.ts                # Entry point of the application
├── docker-compose.yml         # Docker configuration for services
├── package.json               # NPM dependencies and scripts
├── tsconfig.json              # TypeScript configuration
└── README.md                  # Project documentation
```

## Getting Started

### Prerequisites

- Node.js
- Docker (for running the database in a container)

### Installation

1. Clone the repository:
   ```
   git clone <repository-url>
   cd mysql-db-project
   ```

2. Install dependencies:
   ```
   npm install
   ```

3. Set up the database using Docker:
   ```
   docker-compose up -d
   ```

### Configuration

Edit the `src/config/database.ts` file to configure your database connection settings, including host, user, password, and database name.

### Running the Application

To start the application, run:
```
npm start
```

### Migrations

The initial database schema can be found in `src/migrations/init.sql`. You can run this SQL file to set up your database tables.

### Usage

Once the application is running, you can interact with the database through the defined models in `src/models/index.ts`.

## License

This project is licensed under the MIT License.
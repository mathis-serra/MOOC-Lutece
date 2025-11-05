import { Sequelize } from 'sequelize';
import dbConfig from '../config/database';

const sequelize = new Sequelize(dbConfig.database, dbConfig.user, dbConfig.password, {
  host: dbConfig.host,
  dialect: 'mysql', // or 'mariadb'
});

const db = {
  Sequelize,
  sequelize,
  // Define your models here
  // Example: User: require('./User')(sequelize, Sequelize),
};

export default db;
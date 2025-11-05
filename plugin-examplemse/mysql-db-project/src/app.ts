import express from 'express';
import { createConnection } from 'mysql2/promise';
import dbConfig from './config/database';

const app = express();
const port = process.env.PORT || 3000;

async function initializeDatabase() {
    try {
        const connection = await createConnection(dbConfig);
        console.log('Database connected successfully');
        await connection.end();
    } catch (error) {
        console.error('Error connecting to the database:', error);
        process.exit(1);
    }
}

app.get('/', (req, res) => {
    res.send('Hello, World!');
});

app.listen(port, () => {
    console.log(`Server is running on http://localhost:${port}`);
    initializeDatabase();
});

const express = require('express');
const axios = require('axios');
const cors = require('cors');
const app = express();
const port = 8080

const base = process.env.BACKEND_BASE || 'http://localhost';
const addServiceUrl = `${base}:8090/api`
const subtractServiceUrl = `${base}:8070/api`

app.use(cors());

// add
app.post('/api/add/:number1/:number2', async (req, res) => {
    console.log(`Gateway from ${req.ip} with number1=${req.params.number1} and number2=${req.params.number2}`)
    try {
        const response = await axios.post(`${addServiceUrl}/add`, null, {
            params: {
                number1: +req.params.number1,
                number2: +req.params.number2
            }
        });
        const dataFromBackend1 = response.data;
        console.log(`Backend1 returned ${JSON.stringify(dataFromBackend1)}`);
        res.json(dataFromBackend1);
    } catch (error) {
        console.error(error);
        res.status(500).json({error: 'Internal Server Error'});
    }
})

// subtract
app.post('/api/subtract/:number1/:number2', async (req, res) => {
    console.log(`Gateway from ${req.ip} with number1=${req.params.number1} and number2=${req.params.number2}`)
    try {
        const response = await axios.post(`${subtractServiceUrl}/subtract`, null, {
            params: {
                number1: +req.params.number1,
                number2: +req.params.number2
            }
        });
        const dataFromBackend2 = response.data;
        console.log(`Backend2 returned ${JSON.stringify(dataFromBackend2)}`);
        res.json(dataFromBackend2);
    } catch (error) {
        console.error(error);
        res.status(500).json({error: 'Internal Server Error'});
    }
})

app.listen(port, () => {
    console.log(`Gateway listening at http://localhost:${port}`)
})
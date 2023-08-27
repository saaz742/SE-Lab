
const express = require('express');
const axios = require('axios');
const cors = require('cors');
var redis = require('redis');
var client = redis.createClient({
    url: 'redis://:selab6@redis:6379'
});
(async () => {
    await client.connect()
    console.log('Connected to redis')
})()
const app = express();
const port = 8080

const add_base = process.env.BACKEND_ADD_BASE || 'http://localhost';
const sub_base = process.env.BACKEND_SUB_BASE || 'http://localhost';
const addServiceUrl = `${add_base}:8090/api`
const subtractServiceUrl = `${sub_base}:8070/api`

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
        client.set(req.params.number1 + '+' + req.params.number2, dataFromBackend1.result)
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
        client.set(req.params.number1 + '-' + req.params.number2, dataFromBackend2.result)
        res.json(dataFromBackend2);
    } catch (error) {
        console.error(error);
        res.status(500).json({error: 'Internal Server Error'});
    }
})

app.get('/api/history', async (req, res) => {
    console.log(`Gateway from ${req.ip} history request`)
    try {
        json_answer = {}
        keys = await client.keys('*')
        for (var i = 0, len = keys.length; i < len; i++) {
            value = await client.get(keys[i])
            json_answer[keys[i]] = value
        }
        res.json(json_answer);
    } catch (error) {
        console.error(error);
        res.status(500).json({error: 'Internal Server Error'});
    }
})

app.delete('/api/history', async (req, res) => {
    console.log(`Gateway from ${req.ip} history delete ${req.query.key}`)
    try {
        await client.del(req.query.key)
        res.json({result: 'success'});
    } catch (error) {
        console.error(error);
        res.status(500).json({error: 'Internal Server Error'});
    }
})



app.listen(port, () => {
    console.log(`Gateway listening at http://localhost:${port}`)
})
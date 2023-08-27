const express = require('express');
const app = express();
const port = 8090

app.post('/api/add', (req, res) => {

    const number1 = +req.query.number1;
    const number2 = +req.query.number2;
    const result = number1 + number2;
    
    res.json({result});
    console.log(`Add from ${req.ip} with number1=${number1} and number2=${number2}`);
})

app.listen(port, () => {
    console.log(`Add listening at http://localhost:${port}`)
})
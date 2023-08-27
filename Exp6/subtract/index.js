const express = require('express');
const app = express();
const port = 8070

app.post('/api/subtract', (req, res) => {
    
    const number1 = +req.query.number1;
    const number2 = +req.query.number2;
    const result = number1 - number2;

    res.json({result}).end();
    console.log(`Subtract from ${req.ip} with number1=${number1} and number2=${number2}`);
})


app.listen(port, () => {
    console.log(`Subtract listening at http://localhost:${port}`)
})
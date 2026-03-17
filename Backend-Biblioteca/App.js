import express from "express";
import connection from "./dababase.js";

import { PORT } from "./Configurations.js";

const app = express();

app.get('/', (req, res)=>{
    res.send("Hola mundo")
})

app.listen(PORT, () => {
    console.log("Server escuchando en el puerto: " + PORT)
})
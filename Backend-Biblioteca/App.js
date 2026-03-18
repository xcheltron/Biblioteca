import express from "express";
import connection from "./dababase.js";
import routerRol from "./routes/rol.routes.js";
import { PORT } from "./Configurations.js";

const app = express();

//configurations
app.use(express.json())

//Rutas
app.use('/rol', routerRol)

app.listen(PORT, () => {
    console.log("Server escuchando en el puerto: " + PORT)
})
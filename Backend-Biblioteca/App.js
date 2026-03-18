import express from "express";
import connection from "./dababase.js";
import routerRol from "./routes/rol.routes.js";
import routerRegister from "./routes/register.routes.js";
import { PORT } from "./Configurations.js";

const app = express();

//configurations
app.use(express.json())

//Rutas
app.use('/rol', routerRol)
app.use('/register', routerRegister)

app.listen(PORT, () => {
    console.log("Server escuchando en el puerto: " + PORT)
})
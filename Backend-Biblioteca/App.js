import express from "express";
import cors from "cors";
import connection from "./dababase.js";
//RUTAS
import routerRol from "./routes/rol.routes.js";
import routerRegister from "./routes/register.routes.js";
import routerLogin from "./routes/login.routes.js";
import routerBook from "./routes/book.routes.js";
//CONFIGURACIONES
import { PORT } from "./Configurations.js";

const app = express();

//configurations
app.use(express.json())
app.use(cors())

//Rutas
app.use('/rol', routerRol)
app.use('/register', routerRegister)
app.use('/login', routerLogin)
app.use('/book', routerBook)

app.listen(PORT, () => {
    console.log("Server escuchando en el puerto: " + PORT)
})
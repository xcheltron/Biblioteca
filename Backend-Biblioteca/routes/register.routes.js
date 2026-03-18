import express from "express"
import { registerController } from "../controllers/register.controller.js"

const router = express.Router()

router.post('/', registerController)//Controlador para registrarse 

export default router
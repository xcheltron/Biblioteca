import express from "express"
import { loginController } from "../controllers/login.controller.js"

const router = express.Router()

router.get('/', loginController)//controlador para el login

export default router
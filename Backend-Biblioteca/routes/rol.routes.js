import { insertarRolController } from "../controllers/rol.controller.js";
import express from "express"

const router = express.Router()

router.post('/', insertarRolController)


export default router
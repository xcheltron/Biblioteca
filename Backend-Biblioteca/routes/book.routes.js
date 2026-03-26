import { addBookController, consultGeneralBookController } from "../controllers/book.controller.js";
import express from "express"

const router = express.Router()

router.post('/',addBookController)

router.get('/consulta', consultGeneralBookController)

export default router
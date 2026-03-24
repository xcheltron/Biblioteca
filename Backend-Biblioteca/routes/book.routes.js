import { addBookController } from "../controllers/book.controller.js";
import express from "express"

const router = express.Router()

router.post('/',addBookController)

export default router
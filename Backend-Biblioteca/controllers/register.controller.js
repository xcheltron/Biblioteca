import { registerModel } from "../models/register.model.js";
import { SALTROUNDS } from "../Configurations.js";
import bcryp from "bcrypt"

export const registerController = async(req, res) => {
    try {
        const {nameRol, Name, phoneNumber, email, password} = req.body
        const PasswordHash = await bcryp.hashSync(password, parseInt(SALTROUNDS));
        console.log(nameRol, Name, phoneNumber, email, PasswordHash)
        const registro = await registerModel(nameRol, Name, phoneNumber, email, PasswordHash)

        res.status(200).json(registro)
    } catch (error) {
        console.error("Error: " + error)
        res.status(500).json(error)       
    }
}
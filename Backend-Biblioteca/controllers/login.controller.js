import { loginModel } from "../models/login.model.js";
import bcryp from "bcrypt"

export const loginController = async (req, res) =>{
    try {
        const { email, password } = req.body
        const login = await loginModel(email)

        console.log(login)

        if (await bcryp.compareSync(password, login[0][0]._Password)){
            res.status(200).json({"message":"Todo bien"})
        }
        else {
            res.status(204).json({"message":"Contraseña incorrecta"})
        }
        res.status(204).json({"message":"Email incorrecto"})
                
    } catch (error) {
        res.status(204).json({"message":"Hubo un error"})
    }

}
import { insertarRolModel } from "../models/rol.model.js";

export const insertarRolController = async (req, res) =>{
    try {
        const {nameRol} = req.body
        console.log(nameRol)
        const resulInsertarRol = await insertarRolModel(nameRol)

        res.status(200).json(resulInsertarRol)
    } catch (error) {
        res.status(500).json(error)
    }
}
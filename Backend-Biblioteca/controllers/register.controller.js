import { registerModel } from "../models/register.model.js";
import { SALTROUNDS } from "../Configurations.js";
import bcryp from "bcrypt"
import e from "express";

export const registerController = async(req, res) => {
    try {
        const {nameRol, Name, phoneNumber, email, password} = req.body
        const PasswordHash = bcryp.hashSync(password, SALTROUNDS);

        const registro = await registerModel(nameRol, Name, phoneNumber, email, PasswordHash)
        res.status(200).json(registro)
    } catch (error) {
        console.error("Error: " + error)
        res.status(500).json(error)       
    }
}
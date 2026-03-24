import { loginModel } from "../models/login.model.js";
import bcrypt from "bcrypt";

export const loginController = async (req, res) => {
    try {
        const { email, password } = req.body;

        const login = await loginModel(email);

        if (!login || login.length === 0 || login[0].length === 0) {
            return res.status(401).json({ message: "Email incorrecto" });
        }

        const user = login[0][0];

        const match = await bcrypt.compare(password, user._Password);

        if (!match) {
            return res.status(401).json({ message: "Contraseña incorrecta" });
        }

        return res.status(200).json({
            message: "Login exitoso",
            email: email,
            name: user._Name,
            number: user.Phone_number,
            rol: user.NameRol});
  } catch (error) {
    return res.status(500).json({ message: "Hubo un error" });
  }
};

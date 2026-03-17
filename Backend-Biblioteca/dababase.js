import mysql from 'mysql2'

const connection = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "1234",
    database: "library"
})

connection.connect((err) =>{
    if (err){
        console.error('❌No se pudo realizar la coneccion con la base de datos', err)
        return
    }
    console.log('✅ Conexion realizada con exito')
})

export default connection
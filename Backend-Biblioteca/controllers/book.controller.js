import { addBookModel } from "../models/book.model.js";

export const addBookController = async (req, res) => {
  try {
    const { author, Name_Book, Sub_Title, publication_date, quantity } = req.body;

    console.log(author, Name_Book, Sub_Title, publication_date, quantity)

    const book = await addBookModel(
      author,
      Name_Book,
      Sub_Title,
      publication_date,
      quantity,
    );

    if (book[0][0].mensaje === "Todo bien"){res.status(200).json({ message: "Libro guardado con excito" }); return}
        else {res.status(204).json({ message: "ERROR" }); return}    
  } catch (error) {
    res.status(500).json(error);
  }
};

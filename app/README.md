# Book Library App

This application is a book library app developed using Kotlin and Jetpack Compose. It allows users to add books, view book details, and borrow books.

## Features

### Add Book Screen

This screen allows users to add a new book to the library. The user can enter the following details about the book:

- Book Name
- Book Author
- User Name
- Short Description of the book
- Average Book Ratings
- Genre (Maximum of 4 genres can be selected) **Still under development**
- Book Image **Still under development**

The form includes validation for each field to ensure that the user has entered all the necessary information. The image for the book can be selected from the user's device.

### Book Details Screen

This screen displays the details of a selected book. It includes a "Borrow This Book" button. When this button is clicked, a dialog box appears with a slider that allows the user to select the number of days they want to borrow the book.

The dialog box has a nice background shading for a better user experience. The selected number of days is displayed in the dialog box, and the user can confirm their selection by clicking the "Borrow Book" button in the dialog box.

**The Book Image is Hardcoded for now because of a small error, Will be resolved soon**

## Future Enhancements

The application is still under development, **Only UI Has been developed for now, State Management for Form Validation is left and will be done soon, Project Was done within 5 hours before which I had 0 Knowldge of Kotlin**
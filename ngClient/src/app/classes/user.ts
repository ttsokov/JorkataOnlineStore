export class User {
    private _firstName: String;
    private _lastName: String;
    private _username: String;
    private _email: String;
    private _phone: String;
    private _age: Number;
    private _password: String;


  constructor(firstName: String, lastName: String, username: String, email: String, phone: String, age: Number, password: String) {
    this._firstName = firstName;
    this._lastName = lastName;
    this._username = username;
    this._email = email;
    this._phone = phone;
    this._age = age;
    this._password = password;
  }


  get firstName(): String {
    return this._firstName;
  }

  set firstName(value: String) {
    this._firstName = value;
  }

  get lastName(): String {
    return this._lastName;
  }

  set lastName(value: String) {
    this._lastName = value;
  }

  get username(): String {
    return this._username;
  }

  set username(value: String) {
    this._username = value;
  }

  get email(): String {
    return this._email;
  }

  set email(value: String) {
    this._email = value;
  }

  get phone(): String {
    return this._phone;
  }

  set phone(value: String) {
    this._phone = value;
  }

  get age(): Number {
    return this._age;
  }

  set age(value: Number) {
    this._age = value;
  }

  get password(): String {
    return this._password;
  }

  set password(value: String) {
    this._password = value;
  }
}

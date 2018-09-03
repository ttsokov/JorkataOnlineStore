export class User {
    public firstName: String;
    public lastName: String;
    public username: String;
    public email: String;
    public phone: String;
    public age: Number;
    public password: String;


  constructor(firstName: String, lastName: String, username: String, email: String, phone: String, age: Number, password: String) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.email = email;
    this.phone = phone;
    this.age = age;
    this.password = password;
  }
}

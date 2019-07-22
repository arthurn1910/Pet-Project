export class User {
  private _sub: string;
  private _name: string;
  private _autorities: [string]


  get sub(): string {
    return this._sub;
  }

  set sub(value: string) {
    this._sub = value;
  }

  get name(): string {
    return this._name;
  }

  set name(value: string) {
    this._name = value;
  }

  get autorities(): [string] {
    return this._autorities;
  }

  set autorities(value: [string]) {
    this._autorities = value;
  }
}

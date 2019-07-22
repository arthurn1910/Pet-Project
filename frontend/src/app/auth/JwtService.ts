import {JwtHelperService} from '@auth0/angular-jwt';
import {User} from "../model/User";

export class JwtService {

  static decodeToken(token: string) {
    const helper = new JwtHelperService();

    return helper.decodeToken(token) as User;
  }
}

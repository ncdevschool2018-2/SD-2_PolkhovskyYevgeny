import { InMemoryDbService } from 'angular-in-memory-web-api';

import {groupContent} from "./model/groupContent";

export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const firstGroup = [
      {name:'qwe',surname:'mnb'},
      {name:'asd',surname:'hgf'},
      {name:'zxc',surname:'teer'},
      {name:'ter',surname:'rert'},
    ];
    return {firstGroup};
  }

  // Overrides the genId method to ensure that a hero always has an id.
  // If the heroes array is empty,
  // the method below returns the initial number (11).
  // if the heroes array is not empty, the method below returns the highest
  // hero id + 1.
  genId(gc: groupContent[]): number {
    return gc.length > 0 ? Math.max(...gc.map(gc => gc.id)) + 1 : 11;
  }
}

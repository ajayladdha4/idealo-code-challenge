import React from 'react';
import { shallow, render, mount,configure } from 'enzyme';
import Game from './Game';

import Adapter from 'enzyme-adapter-react-16';
import jsdom from 'jsdom';  
const {JSDOM} = jsdom;  
const {document} = (new JSDOM('<!doctype html><html><body></body></html>')).window;  
global.document = document;  
global.window = document.defaultView;

configure({adapter: new Adapter()});
describe('Game', () => {
  let props;
  let renderedGame;

  // const shallowTestComponent = () => {
  //   if (!shallowGame) {
  //     shallowGame = shallow(<Game {...props} />);
  //   }
  //   return shallowGame;
  // };

  const renderTestComponent = () => {
    if (!renderedGame) {
      renderedGame = render(<Game {...props} />);
    }
    return renderedGame;
  };

  // const mountTestComponent = () => {
  //   if (!mountedGame) {
  //     mountedGame = mount(<Game {...props} />);
  //   }
  //   return mountedGame;
  // };  

  beforeEach(() => {
    props = {};
    renderedGame = undefined;
  });

  // Shallow / unit tests begin here
  test('Game render with default props',()=>{
    renderTestComponent();
  })
  // Render / mount / integration tests begin here
  
});

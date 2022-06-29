import React from 'react';
import { shallow, render, mount, configure } from 'enzyme';
import Board from './Board';


import { ButtonHTMLAttributes } from 'react';


import Square from '../Square/Square';

import Adapter from 'enzyme-adapter-react-16';
import jsdom from 'jsdom';  
const {JSDOM} = jsdom;  
const {document} = (new JSDOM('<!doctype html><html><body></body></html>')).window;  
global.document = document;  
global.window = document.defaultView;

configure({adapter: new Adapter()});
describe('Board', () => {
  let props = {
    position:{
      direction: "EAST",
      x: 1,
      y: 1
    },
    robot:{
      id: "qwerty-trewq-1234",
      name: "Ajay's Robot",
    },
    maxX:5,
    maxY:5
  };
  let renderedBoard;
  let mountedBoard;

  const renderTestComponent = () => {
    if (!renderedBoard) {
      renderedBoard = render(<Board {...props} />);
    }
    return renderedBoard;
  };

  const mountTestComponent = () => {
    if (!mountedBoard) {
      mountedBoard = mount(<Board {...props} />);
    }
    return mountedBoard;
  };  

  beforeEach(() => {
    renderedBoard = undefined;
    mountedBoard = undefined;
  });


 
  // Render / mount / integration tests begin here
  test('Board render with default props',()=>{
    const [board] = renderTestComponent();
    expect(board.children.length).toBe(7);
    expect(board.children[0].children[0].data).toBe("Player: Ajay's Robot");
    expect(board.children[1].children[0].attribs.class).toBe("east square");
  })

  test('Board render with default props, total buttons to be 26 (5x5 Square + 1 execute script button)',()=>{
    let mountedComponent = mountTestComponent();
    expect(mountedComponent.find('button').length).toBe(26);
  })
  
});

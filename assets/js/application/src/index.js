import React from 'react';
import dom from 'react-dom';
import Feed from './photos/components/Feed';
import Imaginery from './imaginery/component/Imaginery';

const container = document.querySelector('.photos__content');
const isMobile = window.matchMedia('(max-width: 768px)').matches;

console.log(isMobile);

if (container) {
    dom.render(<Feed />, container);
}

dom.render(<Imaginery width={window.document.body.clientWidth} height={isMobile ? 105 : 375 } />, document.querySelector('.imaginery__placeholder'));



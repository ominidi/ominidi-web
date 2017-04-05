import React from 'react';
import dom from 'react-dom';
import Feed from './photos/components/Feed';
import Imaginery from './imaginery/component/Imaginery';

const container = document.querySelector('.photos__content');

if (container) {
    dom.render(<Feed />, container);
}
dom.render(<Imaginery width={window.innerWidth} height={375} />, document.querySelector('.imaginery__placeholder'));



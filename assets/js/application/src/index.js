import React from 'react';
import dom from 'react-dom';
import Feed from './photos/components/Feed';
import Imaginery from './imaginery/component/Imaginery';

function renderFeed() {
    const container = document.querySelector('.photos__content');

    if (container) {
        dom.render(<Feed />, container);
    }
}

function renderImaginery() {
    function getRatio() {
        const isMobile = window.matchMedia('(max-width: 768px)').matches;
        const width = window.document.body.clientWidth;
        const height = (width * 9) / 21;

        return {
            width: width,
            height: height,
            ratio: width / height,
            isMobile: isMobile
        };
    }

    dom.render(<Imaginery getRatio={ getRatio }/>, document.querySelector('.imaginery__placeholder'));
}

renderFeed();
//renderImaginery();



import React from 'react';
import dom from 'react-dom';
import Feed from './photos/components/Feed';

const container = document.querySelector('.photos__content');

if (container) {
    dom.render(<Feed />, container);
}

import assert from 'assert';
import React from 'react';
import { shallow } from 'enzyme';
import Imaginery from '../../../src/imaginery/component/Imaginery';


describe('#Imaginery', () => {
    it('should render an element ready to be animated', () => {
        const props = { width: 800, height: 600 };
        const wrapper = shallow(<Imaginery { ...props }/>);

        assert.equal(wrapper.hasClass('imaginery'), true);
        assert.deepEqual(wrapper.prop('style'), props);
    });
});

import assert from 'assert';
import sinon from 'sinon';
import React from 'react';
import { shallow } from 'enzyme';
import Imaginery from '../../../src/imaginery/component/Imaginery';


describe('#Imaginery', () => {
    let sandbox, getRatio,
        values = {
            width: 800,
            height: 600,
            ratio: 800 / 600
        };

    beforeEach(() => {
        sandbox = sinon.sandbox.create();
        getRatio = sinon.stub();
        getRatio.onCall().returns(values);
    });

    afterEach(() => {
        getRatio.reset();
    });

    it('should render an element ready to be animated', () => {
        const props = { width: 800, height: 600 };
        const wrapper = shallow(<Imaginery getRatio={getRatio} />);

        assert.equal(wrapper.hasClass('imaginery'), true);
    });

    it.skip('should call getRatio function on window.resize event', () => {
        const wrapper = shallow(<Imaginery getRatio={getRatio} />);
        console.log(wrapper);
    });
});

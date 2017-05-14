import assert from 'assert';
import React from 'react';
import { shallow } from 'enzyme';
import LoadingSpinner from '../../../src/photos/components/LoadingSpinner';

describe('#LoadingSpinner', () => {
    it('should show a loading spinner when load property is true', () => {
        const wrapper = shallow(<LoadingSpinner loading={ true } />);

        assert.equal(wrapper.hasClass('loading-spinner loading'), true);
        assert.equal(wrapper.find('.loading-spinner__animation').length, 1);

        wrapper.setProps({ loading : false });
        assert.equal(wrapper.hasClass('loading'), false);
    });
});

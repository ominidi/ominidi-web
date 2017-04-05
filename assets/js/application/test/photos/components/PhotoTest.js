import assert from 'assert';
import React from 'react';
import { shallow } from 'enzyme';
import Photo from '../../../src/photos/components/Photo';

const data = {
    message: 'Lorem Ipsum',
    objectId: '221946658231380',
    link: 'https://www.facebook.com/ominidi.org/photos/a.221947308231315.1073741828.221685698257476/221946658231380/?type=3',
    permalinkUrl: 'https://www.facebook.com/ominidi.org/posts/221946658231380:0',
    fullPicture: 'https://scontent.xx.fbcdn.net/v/t1.0-9/p720x720/15350731_221946658231380_7655843372792046975_n.jpg?oh=fff641748cce57b36d1db68ce74ced02&oe=58BDC3C6',
    id: '221685698257476_221946658231380'
};

describe('#Photo', () => {
    it('represent a single photo of the feed', () => {
        const wrapper = shallow(<Photo { ...data } />);

        assert.equal(wrapper.hasClass('photos__item'), true);
        assert.equal(wrapper.prop('data-id'), data.id);
        assert.equal(wrapper.find('.card').length, 1);
        assert.equal(wrapper.find('.card__picture').length, 1);
        assert.equal(wrapper.find('.card__picture img').prop('src'), data.fullPicture);
        assert.equal(wrapper.find('.card__caption').text(), data.message);
    });
});

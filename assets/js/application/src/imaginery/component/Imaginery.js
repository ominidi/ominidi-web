import React, {PropTypes} from "react";
import Triangles from '../animation/Triangles';

export default class Imaginery extends  React.Component {
    constructor(props) {
        super(props);
    }

    renderCanvas(el) {
        const { width, height, ratio, isMobile } = this.props.getRatio();
        const scene = Triangles.getScene();
        const camera = Triangles.getCamera((isMobile ? 30 : 75), ratio);
        const renderer = Triangles.getRenderer(width, height);
        const shapes = [
            // Triangles.getTetra(width / 1.7, 2, '#B4FF00'),
            // Triangles.getTetra(width / 1.6, 1, '#EEFF00'),
            // Triangles.getTetra(width / 1.5, 2, '#FF0077'),
            // Triangles.getTetra(width / 1.4, 1, '#0019FF'),
            // Triangles.getTetra(width / 1.3, 2, '#FFFFFF'),
            // Triangles.getTetra(width / 1.2, 1, '#95989A')

            Triangles.getTetra(width / 1.7, 2, '#FFFFFF'),
            Triangles.getTetra(width / 1.6, 1, '#EFEFEF'),
            Triangles.getTetra(width / 1.5, 2, '#95989A'),
            Triangles.getTetra(width / 1.4, 1, '#2E2E2E'),
        ];

        shapes.forEach(shape => {
            scene.add(shape);
        });

        el.appendChild(renderer.domElement);
        Triangles.start(renderer, scene, camera, shapes)();

        window.addEventListener('resize', () => {
            const { width, height, ratio } = this.props.getRatio();
            camera.aspect = ratio;
            camera.updateProjectionMatrix();
            renderer.setSize( width, height );
        }, false);
    }

    render() {
        return (
            <figure className="masthead__picture  imaginery" ref={(el) => {this.renderCanvas(el)}}/>
        );
    }
}

Imaginery.propTypes = {
    width: PropTypes.number,
    height: PropTypes.number
};
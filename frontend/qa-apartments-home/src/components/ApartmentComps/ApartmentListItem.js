import React from 'react';

class ApartmentListItem extends React.Component {
  render() {
      const {apartment}=this.props;
    return (
      <option key={apartment} value={apartment}>Apartment id:{apartment}</option>
    );
  }
}

export default ApartmentListItem;
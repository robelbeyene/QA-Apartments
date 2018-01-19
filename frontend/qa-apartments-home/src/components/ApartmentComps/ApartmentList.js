import React from 'react';

import ApartmentListItem from './ApartmentListItem';

class ApartmentList extends React.Component {
  render() {
      const {list}=this.props;
    return (
            <select id="apartmentSelect">
            {
              list.map(apartment => 
                   <ApartmentListItem apartment={apartment}/>
              )
            }
            </select>
    );
  }
}

export default ApartmentList;
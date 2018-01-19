import React from 'react';

class RoomList extends React.Component {
  render() {
      const {room}=this.props;
    return (
         <option key={room} value={room}>Room id:{room}</option>
    );
  }
}

export default RoomList;
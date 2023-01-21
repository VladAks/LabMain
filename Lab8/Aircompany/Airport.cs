using Aircompany.Models;
using Aircompany.Planes;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Aircompany
{
    public class Airport
    {
        public List<Plane> _planes;
        
        public Airport(IEnumerable<Plane> planes) => _planes = planes.ToList();

        public List<PassengerPlane> GetPassengersPlanes()
        {
            return _planes
               .Where(t => t.GetType() == typeof(PassengerPlane))
               .Cast<PassengerPlane>()
               .ToList();
        }

        public List<MilitaryPlane> GetMilitaryPlanes()
        {
            return _planes
             .Where(t => t.GetType() == typeof(MilitaryPlane))
             .Cast<MilitaryPlane>()
             .ToList();
        }

       
        public PassengerPlane GetPassengerPlaneWithMaxPassengersCapacity()
        {
            return GetPassengersPlanes().Aggregate((w, x) => w.PassengersCapacityIs() > x.PassengersCapacityIs() ? w : x);             
        }

        public List<MilitaryPlane> GetTransportMilitaryPlanes()
        {
            return GetMilitaryPlanes()
                  .Where(plane => plane.Type == MilitaryTypes.Transport)
                  .ToList();
        }

        public Airport SortByMaxDistance() => new Airport(_planes.OrderBy(w => w.MaxLoadCapacity));

        public Airport SortByMaxSpeed() => new Airport(_planes.OrderBy(w => w.MaxSpeed));

        public Airport SortByMaxLoadCapacity() => new Airport(_planes.OrderBy(w => w.MaxLoadCapacity));

        public IEnumerable<Plane> GetPlanes() => _planes;

        public override string ToString()
        {
            return "Airport{planes=" + string.Join(", ", _planes.Select(x => x.Model)) + '}';
        }
    }
}

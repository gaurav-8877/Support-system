import React from 'react';
import { Player } from '../types/Player';

interface PlayerCardProps {
  player: Player;
  onEdit: (player: Player) => void;
  onDelete: (id: number) => void;
}

const PlayerCard: React.FC<PlayerCardProps> = ({ player, onEdit, onDelete }) => {
  const handleDelete = () => {
    if (window.confirm(`Are you sure you want to delete ${player.name}?`)) {
      onDelete(player.id!);
    }
  };

  return (
    <div className="bg-card border rounded-lg p-6 shadow-sm">
      <div className="flex justify-between items-start mb-4">
        <h3 className="text-lg font-semibold text-foreground">{player.name}</h3>
        <div className="flex gap-2">
          <button 
            onClick={() => onEdit(player)} 
            className="px-3 py-1 text-sm bg-primary text-primary-foreground rounded hover:bg-primary/90"
          >
            Edit
          </button>
          <button 
            onClick={handleDelete} 
            className="px-3 py-1 text-sm bg-destructive text-destructive-foreground rounded hover:bg-destructive/90"
          >
            Delete
          </button>
        </div>
      </div>
      
      <div className="space-y-2">
        <div>
          <strong className="text-foreground">Email:</strong> <span className="text-muted-foreground">{player.email}</span>
        </div>
        
        {player.phone && (
          <div>
            <strong className="text-foreground">Phone:</strong> <span className="text-muted-foreground">{player.phone}</span>
          </div>
        )}
        
        {player.address && (
          <div>
            <strong className="text-foreground">Address:</strong> <span className="text-muted-foreground">{player.address}</span>
          </div>
        )}
        
        {player.sport && (
          <div>
            <strong className="text-foreground">Sport:</strong> 
            <span className="ml-2 px-2 py-1 bg-accent text-accent-foreground rounded text-sm">{player.sport}</span>
          </div>
        )}
        
        {player.skillLevel && (
          <div>
            <strong className="text-foreground">Skill Level:</strong> 
            <span className="ml-2 px-2 py-1 bg-secondary text-secondary-foreground rounded text-sm">
              {player.skillLevel}
            </span>
          </div>
        )}
        
        {player.backgroundStory && (
          <div className="mt-4">
            <strong className="text-foreground">Background Story:</strong>
            <p className="text-muted-foreground mt-1">{player.backgroundStory}</p>
          </div>
        )}
      </div>
    </div>
  );
};

export default PlayerCard;
import { Player } from '../types/Player';

const API_BASE_URL = 'http://localhost:8080/api/players';

export class PlayerService {
  static async getAllPlayers(): Promise<Player[]> {
    const response = await fetch(API_BASE_URL);
    if (!response.ok) {
      throw new Error('Failed to fetch players');
    }
    return response.json();
  }

  static async getPlayerById(id: number): Promise<Player> {
    const response = await fetch(`${API_BASE_URL}/${id}`);
    if (!response.ok) {
      throw new Error('Failed to fetch player');
    }
    return response.json();
  }

  static async createPlayer(player: Player): Promise<Player> {
    const response = await fetch(API_BASE_URL, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(player),
    });
    if (!response.ok) {
      throw new Error('Failed to create player');
    }
    return response.json();
  }

  static async updatePlayer(id: number, player: Player): Promise<Player> {
    const response = await fetch(`${API_BASE_URL}/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(player),
    });
    if (!response.ok) {
      throw new Error('Failed to update player');
    }
    return response.json();
  }

  static async deletePlayer(id: number): Promise<void> {
    const response = await fetch(`${API_BASE_URL}/${id}`, {
      method: 'DELETE',
    });
    if (!response.ok) {
      throw new Error('Failed to delete player');
    }
  }

  static async searchPlayersByName(name: string): Promise<Player[]> {
    const response = await fetch(`${API_BASE_URL}/search?name=${encodeURIComponent(name)}`);
    if (!response.ok) {
      throw new Error('Failed to search players');
    }
    return response.json();
  }

  static async getPlayersBySport(sport: string): Promise<Player[]> {
    const response = await fetch(`${API_BASE_URL}/sport/${encodeURIComponent(sport)}`);
    if (!response.ok) {
      throw new Error('Failed to fetch players by sport');
    }
    return response.json();
  }

  static async getPlayersBySkillLevel(skillLevel: string): Promise<Player[]> {
    const response = await fetch(`${API_BASE_URL}/skill/${encodeURIComponent(skillLevel)}`);
    if (!response.ok) {
      throw new Error('Failed to fetch players by skill level');
    }
    return response.json();
  }
}
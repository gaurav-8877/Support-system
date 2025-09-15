const API_BASE = process.env.REACT_APP_API_BASE || 'http://localhost:8080';

export type Mentorship = {
  id?: number;
  mentorName: string;
  menteeName: string;
  goals: string;
  status: string; // ACTIVE | COMPLETED | PENDING
};

function authHeader(username?: string, password?: string): HeadersInit {
  if (!username || !password) return {};
  const token = btoa(`${username}:${password}`);
  return { Authorization: `Basic ${token}` };
}

export async function listMentorships(): Promise<Mentorship[]> {
  const res = await fetch(`${API_BASE}/api/mentorships`);
  if (!res.ok) throw new Error('Failed to load mentorships');
  return res.json();
}

export async function createMentorship(data: Mentorship, username?: string, password?: string): Promise<Mentorship> {
  const res = await fetch(`${API_BASE}/api/mentorships`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      ...authHeader(username, password),
    },
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error('Failed to create mentorship');
  return res.json();
}

export async function updateMentorship(id: number, data: Mentorship, username?: string, password?: string): Promise<Mentorship> {
  const res = await fetch(`${API_BASE}/api/mentorships/${id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
      ...authHeader(username, password),
    },
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error('Failed to update mentorship');
  return res.json();
}

export async function deleteMentorship(id: number, username?: string, password?: string): Promise<void> {
  const res = await fetch(`${API_BASE}/api/mentorships/${id}`, {
    method: 'DELETE',
    headers: {
      ...authHeader(username, password),
    },
  });
  if (!res.ok) throw new Error('Failed to delete mentorship');
}
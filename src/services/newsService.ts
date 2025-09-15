const API_BASE = process.env.REACT_APP_API_BASE || 'http://localhost:8080';

export type NewsItem = {
  id?: number;
  title: string;
  content: string;
  publishedAt?: string;
};

export async function listNews(): Promise<NewsItem[]> {
  const res = await fetch(`${API_BASE}/api/news`);
  if (!res.ok) throw new Error('Failed to load news');
  return res.json();
}

function authHeader(username?: string, password?: string): HeadersInit {
  if (!username || !password) return {};
  const token = btoa(`${username}:${password}`);
  return { Authorization: `Basic ${token}` };
}

export async function createNews(item: NewsItem, username?: string, password?: string): Promise<NewsItem> {
  const res = await fetch(`${API_BASE}/api/news`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      ...authHeader(username, password),
    },
    body: JSON.stringify(item),
  });
  if (!res.ok) throw new Error('Failed to create news');
  return res.json();
}

export async function deleteNews(id: number, username?: string, password?: string): Promise<void> {
  const res = await fetch(`${API_BASE}/api/news/${id}`, {
    method: 'DELETE',
    headers: { ...authHeader(username, password) },
  });
  if (!res.ok) throw new Error('Failed to delete news');
}